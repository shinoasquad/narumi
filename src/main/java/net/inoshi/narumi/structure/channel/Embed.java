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

package net.inoshi.narumi.structure.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author vocan
 * @since 31.07.2019
 */
@Value.Immutable
@JsonSerialize(as = ImmutableEmbed.class)
@JsonDeserialize(as = ImmutableEmbed.class)
public interface Embed {

    Optional<String> title();

    Optional<String> type();

    Optional<String> description();

    Optional<String> url();

    Optional<ZonedDateTime> timestamp();

    Optional<Integer> color();

    Optional<Footer> footer();

    Optional<Image> image();

    Optional<Thumbnail> thumbnail();

    Optional<Video> video();

    Optional<Provider> provider();

    Optional<Author> author();

    Optional<Field[]> fields();

    @Value.Immutable
    @JsonSerialize(as = ImmutableEmbed.Thumbnail.class)
    @JsonDeserialize(as = ImmutableEmbed.Thumbnail.class)
    interface Thumbnail {

        Optional<String> url();

        @JsonProperty("proxy_url") Optional<String> proxyUrl();

        Optional<Integer> height();

        Optional<Integer> width();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableEmbed.Video.class)
    @JsonDeserialize(as = ImmutableEmbed.Video.class)
    interface Video {

        Optional<String> url();

        Optional<Integer> height();

        Optional<Integer> width();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableEmbed.Author.class)
    @JsonDeserialize(as = ImmutableEmbed.Author.class)
    interface Author {

        Optional<String> name();

        Optional<String> url();

        @JsonProperty("icon_url") Optional<String> iconUrl();

        @JsonProperty("proxy_icon_url") Optional<String> proxyIconUrl();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableEmbed.Field.class)
    @JsonDeserialize(as = ImmutableEmbed.Field.class)
    interface Field {

        String name();

        String value();

        Optional<Boolean> inline();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableEmbed.Footer.class)
    @JsonDeserialize(as = ImmutableEmbed.Footer.class)
    interface Footer {

        String text();

        @JsonProperty("icon_url") Optional<String> iconUrl();

        @JsonProperty("proxy_icon_url") Optional<String> proxyIconUrl();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableEmbed.Image.class)
    @JsonDeserialize(as = ImmutableEmbed.Image.class)
    interface Image {

        Optional<String> url();

        @JsonProperty("proxy_url") Optional<String> proxyUrl();

        Optional<Integer> height();

        Optional<Integer> width();

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableEmbed.Provider.class)
    @JsonDeserialize(as = ImmutableEmbed.Provider.class)
    interface Provider {

        Optional<String> name();

        Optional<String> url();

    }

}
