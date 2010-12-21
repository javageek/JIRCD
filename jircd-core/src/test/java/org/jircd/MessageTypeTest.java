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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** @author <a href="mailto:github@javageek.org">Guillermo Castro</a> */
public class MessageTypeTest {
    private static final String TEST_COMMAND = "PRIVMSG";
    private static final String TEST_INVALID_COMMAND = "TXT";

    @Test
    public void testFromCode() throws Exception {
        MessageType type = MessageType.fromCommand(TEST_COMMAND);
        assertEquals(MessageType.PRIVMSG, type);
        assertEquals(TEST_COMMAND, type.getCommand());
    }

    @Test
    public void testFromInvalidCode() throws Exception {
        MessageType type = MessageType.fromCommand(TEST_INVALID_COMMAND);
        assertEquals(MessageType.UNKNOWN, type);
    }

}
