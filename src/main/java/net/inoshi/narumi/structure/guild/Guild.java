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

package net.inoshi.narumi.structure.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.inoshi.narumi.structure.channel.Channel;
import net.inoshi.narumi.structure.emoji.Emoji;
import net.inoshi.narumi.structure.user.Presence;
import net.inoshi.narumi.structure.voice.State;
import org.immutables.value.Value;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author vocan
 * @since 31.07.2019
 */
@Value.Immutable
@JsonSerialize(as = ImmutableGuild.class)
@JsonDeserialize(as = ImmutableGuild.class)
public interface Guild {

    long id();

    String name();

    Optional<String> icon();

    Optional<String> splash();

    Optional<Boolean> owner();

    @JsonProperty("owner_id") long ownerId();

    Optional<Integer> permissions();

    String region();

    @JsonProperty("afk_channel_id") Optional<Long> afkChannelId();

    @JsonProperty("afk_timeout") int afkTimeout();

    @JsonProperty("embed_enabled") Optional<Boolean> embedEnabled();

    @JsonProperty("embed_channel_id") Optional<Long> embedChannelId();

    @JsonProperty("verification_level") int verificationLevel();

    @JsonProperty("default_message_notifications") int defaultMessageNotifications();

    @JsonProperty("explicit_content_filter") int explicitContentFilter();

    Role[] roles();

    Emoji[] emojis();

    String[] features();

    @JsonProperty("mfa_level") int mfaLevel();

    @JsonProperty("application_id") Optional<Long> applicationId();

    @JsonProperty("widget_enabled") Optional<Boolean> widgetEnabled();

    @JsonProperty("widget_channel_id") Optional<Long> widgetChannelId();

    @JsonProperty("system_channel_id") Optional<Long> systemChannelId();

    @JsonProperty("joined_at") Optional<ZonedDateTime> joinedAt();

    Optional<Boolean> large();

    Optional<Boolean> unavailable();

    @JsonProperty("member_count") int memberCount();

    @JsonProperty("voice_states") Optional<State[]> voiceStates();

    Optional<Member[]> members();

    Optional<Channel[]> channels();

    Optional<Presence> presences();

    @JsonProperty("max_presences") Optional<Integer> maxPresences();

    @JsonProperty("max_members") Optional<Integer> maxMembers();

    @JsonProperty("vanity_url_code") Optional<String> vanityUrlCode();

    Optional<String> description();

    Optional<String> banner();

    @JsonProperty("premium_tier") int premiumTier();

    @JsonProperty("premium_subscription_count") Optional<Integer> premiumSubscriptionCount();

}
