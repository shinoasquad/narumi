/*
 * Copyright (c) 2019, inoshi
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.inoshi.narumi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import net.inoshi.narumi.common.transformation.ZonedDateTimeTransformer;
import net.inoshi.narumi.service.message.MessageService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.ZonedDateTime;
import java.util.concurrent.Executors;

/**
 * @author vocan
 * @since 30.07.2019
 */
public final class Narumi {

    private final MessageService messageService;

    public Narumi(final String token) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .client(new OkHttpClient().newBuilder()
                        .addInterceptor(chain -> chain.proceed(chain.request().newBuilder().addHeader("Authorization", "Bot " + token).build())).build())
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()
                        .registerModule(new SimpleModule()
                                .addSerializer(ZonedDateTime.class, new ZonedDateTimeTransformer.ZonedDateTimeSerializer())
                                .addDeserializer(ZonedDateTime.class, new ZonedDateTimeTransformer.ZonedDateTimeDeserializer()))))
                .callbackExecutor(Executors.newFixedThreadPool(4))
                .build();
        this.messageService = retrofit.create(MessageService.class);
    }


    public MessageService getMessageService() {
        return this.messageService;
    }

}
