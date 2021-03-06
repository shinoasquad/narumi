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

package net.inoshi.narumi.structure.invite;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.inoshi.narumi.structure.channel.Channel;
import net.inoshi.narumi.structure.guild.Guild;
import net.inoshi.narumi.structure.user.User;
import org.immutables.value.Value;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author vocan
 * @since 31.07.2019
 */
@Value.Immutable
@JsonSerialize(as = ImmutableInvite.class)
@JsonDeserialize(as = ImmutableInvite.class)
public interface Invite {

    String code();

    Optional<Guild> guild();

    Channel channel();

    @JsonProperty("target_user") User targetUser();

    @JsonProperty("target_user_type") Optional<Integer> targetUserType();

    @JsonProperty("approximate_presence_count") Optional<Integer> approximatePresenceCount();

    @JsonProperty("approximate_member_count") Optional<Integer> approximateMemberCount();

    @Value.Immutable
    @JsonSerialize(as = ImmutableInvite.Metadata.class)
    @JsonDeserialize(as = ImmutableInvite.Metadata.class)
    interface Metadata {

        User inviter();

        int uses();

        @JsonProperty("max_uses") int maxUses();

        @JsonProperty("max_age") int maxAge();

        boolean temporary();

        @JsonProperty("created_at") ZonedDateTime createdAt();

        boolean revoked();

    }

}
