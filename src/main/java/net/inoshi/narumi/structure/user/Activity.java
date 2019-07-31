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

package net.inoshi.narumi.structure.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * @author vocan
 * @since 31.07.2019
 */
@Value.Immutable
@JsonSerialize(as = ImmutableActivity.class)
@JsonDeserialize(as = ImmutableActivity.class)
public interface Activity {

    String name();

    int type();

    Optional<String> url();

    Optional<Timestamp> timestamps();

    @JsonProperty("application_id") Optional<Long> applicationId();

    Optional<String> details();

    Optional<String> state();

    Optional<Party> party();

    Optional<Assets> assets();

    Optional<Secrets> secrets();

    Optional<Boolean> instance();

    Optional<Integer> flags();

    @JsonSerialize(as = ImmutableActivity.Assets.class)
    @JsonDeserialize(as = ImmutableActivity.Assets.class)
    interface Assets {

        @JsonProperty("large_image") Optional<String> largeImage();

        @JsonProperty("large_text") Optional<String> largeText();

        @JsonProperty("small_image") Optional<String> smallImage();

        @JsonProperty("small_text") Optional<String> smallText();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableActivity.Party.class)
    @JsonDeserialize(as = ImmutableActivity.Party.class)
    interface Party {

        Optional<String> id();

        Optional<Integer[]> size();


    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableActivity.Secrets.class)
    @JsonDeserialize(as = ImmutableActivity.Secrets.class)
    interface Secrets {

        Optional<String> join();

        Optional<String> spectate();

        Optional<String> match();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableActivity.Status.class)
    @JsonDeserialize(as = ImmutableActivity.Status.class)
    interface Status {

        Optional<String> desktop();

        Optional<String> mobile();

        Optional<String> web();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableActivity.Timestamp.class)
    @JsonDeserialize(as = ImmutableActivity.Timestamp.class)
    interface Timestamp {

        Optional<Integer> start();

        Optional<Integer> end();

    }

}
