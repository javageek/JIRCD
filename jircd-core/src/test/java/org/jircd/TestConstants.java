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

/** @author <a href="mailto:github@javageek.org">Guillermo Castro</a> */
public interface TestConstants {
    String PRE = ":";
    String SRV = "irc.server.com";
    String SPC = " ";
    String USR = "nickname!~user@domain.com";
    String CMD = "PRIVMSG";
    String CHN = "#channel";
    String LST = "Hello  World!";
    String CTCP_MSG = "\u0001ACTION waves\u0001";
    String INVALID_CMD = "TXT";
    String CRLF = "\r\n";

    String CODE_STR = "001";
    String VERSION_CODE_STR = "351";
    String INVALID_CODE_STR = "TXT";
    int CODE = 1;
    int INVALID_CODE = -1;
}
