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
 * Enumerate all the known (RFC2812) message types.
 *
 * @author <a href="mailto:github@javageek.org">Guillermo Castro</a>
 */
public enum MessageType {
    // Connection Registration (3.1)
    PASS("PASS"), // (3.1.1)
    NICK("NICK"), // (3.1.2)
    USER("USER"), // (3.1.3)
    OPER("OPER"), // (3.1.4)
    MODE("MODE"), // (3.1.5) (3.2.3)
    SERVICE("SERVICE"), // (3.1.6)
    QUIT("QUIT"), // (3.1.7)
    SQUIT("SQUIT"), // (3.1.8)
    // Channel Operations (3.2)
    JOIN("JOIN"), // (3.2.1)
    PART("PART"), // (3.2.2)
    TOPIC("TOPIC"), // (3.2.4)
    NAMES("NAMES"), // (3.2.5)
    LIST("LIST"), // (3.2.6)
    INVITE("INVITE"), // (3.2.7)
    KICK("KICK"), // (3.2.8)
    // Sending Messages (3.3)
    PRIVMSG("PRIVMSG"), // (3.3.1)
    NOTICE("NOTICE"), // (3.3.2)
    // Server queries (3.4)
    MOTD("MOTD"), // (3.4.1)
    LUSERS("LUSERS"), // (3.4.2)
    VERSION("VERSION"), // (3.4.3)
    STATS("STATS"), // (3.4.4)
    LINKS("LINKS"), // (3.4.5)
    TIME("TIME"), // (3.4.6)
    CONNECT("CONNECT"), // (3.4.7)
    TRACE("TRACE"), // (3.4.8)
    ADMIN("ADMIN"), // (3.4.9)
    INFO("INFO"), // (3.4.10)
    // Service Queries (3.5)
    SERVLIST("SERVLIST"), // (3.5.1)
    SQUERY("SQUERY"), // (3.5.2)
    // User Queries (3.6)
    WHO("WHO"), // (3.6.1)
    WHOIS("WHOIS"), // (3.6.2)
    WHOWAS("WHOWAS"), // (3.6.3)
    // Miscellaneous (3.7)
    KILL("KILL"), // (3.7.1)
    PING("PING"), // (3.7.2)
    PONG("PONG"), // (3.7.3)
    ERROR("ERROR"), // (3.7.4)
    // Optional Features (4)
    AWAY("AWAY"), // (4.1)
    REHASH("REHASH"), // (4.2)
    DIE("DIE"), // (4.3)
    RESTART("RESTART"), // (4.4)
    SUMMON("SUMMON"), // (4.5)
    USERS("USERS"), // (4.6)
    WALLOS("WALLOPS"), // (4.7)
    USERHOST("USERHOST"), // (4.8)
    ISON("ISON"), // (4.9)
    UNKNOWN("");

    private String command;

    /**
     * Private constructor for creating enumerations.
     *
     * @param command of type String representing the command from the specs.
     */
    private MessageType(String command) {
        this.command = command;
    }

    /**
     * Return the MessageType from the string command.
     *
     * @param command of type String
     * @return MessageType
     */
    public static MessageType fromCommand(String command) {
        MessageType type = UNKNOWN;

        for (MessageType messageType : MessageType.values()) {
            if (messageType.getCommand().equals(command)) {
                type = messageType;
                break;
            }
        }

        return type;
    }

    /**
     * Gets the command string
     *
     * @return the command (type String) of this MessageType object.
     */
    public String getCommand() {
        return command;
    }


    @Override
    public String toString() {
        return getCommand();
    }
}
