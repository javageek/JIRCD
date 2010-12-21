/*
 * Copyright (c) 2010 Guillermo Castro
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jircd;

/**
 * Enumerate all the reply codes from the RFC2812 specs.
 *
 * @author <a href="mailto:github@javageek.org">Guillermo Castro</a>
 */
public enum ReplyType {
    // The server sends Replies 001 to 004 to a user upon successful registration.
    RPL_WELCOME(1),
    RPL_YOURHOST(2),
    RPL_CREATED(3),
    RPL_MYINFO(4),
    /** Sent by the server to a user to suggest an alternative server. This is often used when the connection is refused because the server is already full. */
    RPL_BOUNCE(5),
    /** Reply format used by USERHOST to list replies to the query list. */
    RPL_USERHOST(302),
    /** Reply format used by ISON to list replies to the query list. */
    RPL_ISON(303),
    // These replies are used with the AWAY command (if allowed).
    RPL_AWAY(301),
    RPL_UNAWAY(305),
    RPL_NOAWAY(306),
    // Replies 311 - 313, 317 - 319 are all replies generated in response to a WHOIS message.
    RPL_WHOISUSER(311),
    RPL_WHOISSERVER(312),
    RPL_WHOISOPERATOR(313),
    RPL_WHOISIDLE(317),
    RPL_ENDOFWHOIS(318),
    RPL_WHOISCHANNELS(319),
    RPL_WHOWASUSER(314),
    RPL_ENDOFWHOWAS(369),
    /** Obsolete. Not used. @Deprecated */
    RPL_LISTSTART(321),
    RPL_LIST(322),
    RPL_LISTEND(323),
    RPL_UNIQOPIS(325),
    RPL_CHANNELMODEIS(324),
    RPL_NOTOPIC(331),
    RPL_TOPIC(332),
    RPL_INVITING(341),
    RPL_SUMMONING(342),
    RPL_INVITELIST(346),
    RPL_ENDOFINVITELIST(347),
    RPL_EXCEPTLIST(348),
    RPL_ENDOFEXCEPTLIST(349),
    RPL_VERSION(351),
    RPL_WHOREPLY(352),
    RPL_ENDOFWHO(315),
    RPL_NAMREPLY(353),
    RPL_ENDOFNAMES(366),
    RPL_LINKS(364),
    RPL_ENDOFLINKS(365),
    RPL_BANLIST(367),
    RPL_ENDOFBANLIST(368),
    RPL_INFO(371),
    RPL_ENDOFINFO(374),
    RPL_MOTDSTART(375),
    RPL_MOTD(372),
    RPL_ENDOFMOTD(376),
    RPL_YOUREOPER(381),
    RPL_REHASHING(382),
    RPL_YOURESERVICE(383),
    RPL_TIME(391),
    RPL_USERSSTART(392),
    RPL_USERS(393),
    RPL_ENDOFUSERS(394),
    RPL_NOUSERS(395),
    RPL_TRACELINK(200),
    RPL_TRACECONNECTING(201),
    RPL_TRACEHANDSHAKE(202),
    RPL_TRACEUNKNOWN(203),
    RPL_TRACEOPERATOR(204),
    RPL_TRACEUSER(205),
    RPL_TRACESERVER(206),
    RPL_TRACESERVICE(207),
    RPL_TRACENEWTYPE(208),
    RPL_TRACECLASS(209),
    RPL_TRACERECONNECT(210),
    RPL_TRACELOG(261),
    RPL_TRACEEND(262),
    RPL_STATSLINKINFO(211),
    RPL_STATSCOMMANDS(212),
    RPL_ENDOFSTATS(219),
    RPL_STATSUPTIME(242),
    RPL_STATSOLINE(243),
    RPL_UMODEIS(221),
    RPL_SERVLIST(234),
    RPL_SERVLISTEND(235),
    RPL_LUSERCLIENT(251),
    RPL_LUSEROP(252),
    RPL_LUSERUNKNOWN(253),
    RPL_LUSERCHANNELS(254),
    RPL_LUSERME(255),
    RPL_ADMINME(256),
    RPL_ADMINLOC1(257),
    RPL_ADMINLOC2(258),
    RPL_ADMINEMAIL(259),
    RPL_TRYAGAIN(263),
    // Error messages
    ERR_NOSUCHNICK(401),
    ERR_NOSUCHSERVER(402),
    ERR_NOSUCHCHANNEL(403),
    ERR_CANNOTSENDTOCHAN(404),
    ERR_TOOMANYCHANNELS(405),
    ERR_WASNOSUCHNICK(406),
    ERR_TOOMANYTARGETS(407),
    ERR_NOSUCHSERVICE(408),
    ERR_NOORIGIN(409),
    ERR_NORECIPIENT(411),
    // 412 - 415 are returned by PRIVMSG to indicate that the message wasn’t delivered for some reason.
    ERR_NOTEXTTOSEND(412),
    ERR_NOTOPLEVEL(413),
    ERR_WILDTOPLEVEL(414),
    ERR_BADMASK(415),
    ERR_UNKNOWNCOMMAND(421),
    ERR_NOMOTD(422),
    ERR_NOADMININFO(423),
    ERR_FILEERROR(424),
    ERR_NONICKNAMEGIVEN(431),
    ERR_ERRONEUSNICKNAME(432),
    ERR_NICKNAMEINUSE(433),
    ERR_NICKCOLLISION(436),
    ERR_UNAVAILRESOURCE(437),
    ERR_USERNOTINCHANNEL(441),
    ERR_NOTONCHANNEL(442),
    ERR_USERONCHANNEL(443),
    ERR_NOLOGIN(444),
    ERR_SUMMONDISABLED(445),
    ERR_USERSDISABLED(446),
    ERR_NOTREGISTERED(451),
    ERR_NEEDMOREPARAMS(461),
    ERR_ALREADYREGISTRED(462),
    ERR_NOPERMFORHOST(463),
    ERR_PASSWDMISMATCH(464),
    ERR_YOUREBANNEDCREEP(465),
    ERR_YOUWILLBEBANNED(466),
    ERR_KEYSET(467),
    ERR_CHANNELISFULL(471),
    ERR_UNKNOWNMODE(472),
    ERR_INVITEONLYCHAN(473),
    ERR_BANNEDFROMCHAN(474),
    ERR_BADCHANNELKEY(475),
    ERR_BADCHANMASK(476),
    ERR_NOCHANMODES(477),
    ERR_BANLISTFULL(478),
    ERR_NOPRIVILEGES(481),
    ERR_CHANOPRIVSNEEDED(482),
    ERR_CANTKILLSERVER(483),
    ERR_RESTRICTED(484),
    ERR_UNIQOPPRIVSNEEDED(485),
    ERR_NOOPERHOST(491),
    ERR_UMODEUNKNOWNFLAG(501),
    ERR_USERSDONTMATCH(502),
    // Reserved numerics
    RPL_SERVICEINFO(231),
    RPL_ENDOFSERVICES(232),
    RPL_SERVICE(233),
    RPL_NONE(300),
    RPL_WHOISCHANOP(316),
    RPL_KILLDONE(361),
    RPL_CLOSING(362),
    RPL_CLOSEEND(363),
    RPL_INFOSTART(373),
    RPL_MYPORTIS(384),
    RPL_STATSCLINE(213),
    RPL_STATSNLINE(214),
    RPL_STATSILINE(215),
    RPL_STATSKLINE(216),
    RPL_STATSQLINE(217),
    RPL_STATSYLINE(218),
    RPL_STATSVLINE(240),
    RPL_STATSLLINE(241),
    RPL_STATSHLINE(244),
    RPL_STATSSLINE(245),
    RPL_STATSPING(246),
    RPL_STATSBLINE(247),
    RPL_STATSDLINE(250),
    ERR_NOSERVICEHOST(492),
    UNKNOWN(0);
    private int code;

    private ReplyType(int code) {
        this.code = code;
    }

    public static ReplyType fromCode(int code) {
        ReplyType reply = UNKNOWN;

        for (ReplyType type : ReplyType.values()) {
            if (type.getCode() == code) {
                reply = type;
                break;
            }
        }

        return reply;
    }

    public static ReplyType fromCode(String codeStr) {
        ReplyType reply = UNKNOWN;

        try {
            reply = fromCode(Integer.parseInt(codeStr));
        } catch (NumberFormatException nfe) {
            // It's not an integer, so do nothing
        }

        return reply;
    }

    public int getCode() {
        return code;
    }

    /**
     * Convert enumeration to String representation with leading zeros for replies between 001-099.
     * @return String reply code, zero padded.
     */
    @Override
    public String toString() {
        return String.format("%03d", code);
    }
}
