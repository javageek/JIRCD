/*
 * Copyright (c) 2010 Guillermo Castro
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.jircd;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/** @author <a href="mailto:github@javageek.org">Guillermo Castro</a> */
public class MessageTest {
    private static final String PRE = ":";
    private static final String SRV = "irc.server.com";
    private static final String SPC = " ";
    private static final String USR = "nickname!~user@hostname";
    private static final String CMD = "PRIVMSG";
    private static final String CHN = "#channel";
    private static final String LST = "Hello  World!";

    private static final String TEST_WHITESPACE = SPC;
    private static final String TEST_COMMAND = CMD;
    private static final String TEST_COMMAND_PARAMETER = CMD + SPC + CHN;
    private static final String TEST_COMMAND_LASTPARAMETER = CMD + SPC + PRE + SRV;
    private static final String TEST_COMMAND_PARAMETER_LASTPARAMETER = CMD + SPC + CHN + SPC + PRE + LST;
    private static final String TEST_PREFIX_COMMAND = PRE + SRV + SPC + CMD;
    private static final String TEST_PREFIX_COMMAND_PARAMETER = PRE + USR + SPC + CMD + SPC + CHN;
    private static final String TEST_PREFIX_COMMAND_LASTPARAMETER = PRE + USR + SPC + CMD + SPC + PRE + LST;
    private static final String TEST_PREFIX_COMMAND_PARAMETER_LASTPARAMETER = PRE + USR + SPC + CMD + SPC + CHN + SPC + PRE + LST;

    @Test
    public void testWhitespace() {
        Message msg = Message.parseFrom(TEST_WHITESPACE);
        assertNull(msg);
    }

    @Test
    public void testCommand() {
        Message msg = Message.parseFrom(TEST_COMMAND);
        assertNotNull(msg);
        assertEquals(CMD, msg.getCommand());
    }

    @Test
    public void testCommandParameter() {
        Message msg = Message.parseFrom(TEST_COMMAND_PARAMETER);
        assertNotNull(msg);
        assertEquals(CMD, msg.getCommand());
        assertNotNull(msg.getParameters());
        assertArrayEquals(new String[]{CHN}, msg.getParameters().toArray());
    }

    @Test
    public void testCommandLastParameter() {
        Message msg = Message.parseFrom(TEST_COMMAND_LASTPARAMETER);
        assertNotNull(msg);
        assertEquals(CMD, msg.getCommand());
        assertEquals(SRV, msg.getLastParameter());
    }

    @Test
    public void testCommandParameterLastParameter() {
        Message msg = Message.parseFrom(TEST_COMMAND_PARAMETER_LASTPARAMETER);
        assertNotNull(msg);
        assertEquals(CMD, msg.getCommand());
        assertNotNull(msg.getParameters());
        assertArrayEquals(new String[]{CHN}, msg.getParameters().toArray());
        assertEquals(LST, msg.getLastParameter());
    }

    @Test
    public void testPrefixCommand() {
        Message msg = Message.parseFrom(TEST_PREFIX_COMMAND);
        assertNotNull(msg);
        assertEquals(SRV, msg.getPrefix());
        assertEquals(CMD, msg.getCommand());
    }

    @Test
    public void testPrefixCommandParameter() {
        Message msg = Message.parseFrom(TEST_PREFIX_COMMAND_PARAMETER);
        assertNotNull(msg);
        assertEquals(USR, msg.getPrefix());
        assertEquals(CMD, msg.getCommand());
        assertNotNull(msg.getParameters());
        assertArrayEquals(new String[]{CHN}, msg.getParameters().toArray());
    }

    @Test
    public void testPrefixCommandLastParameter() {
        Message msg = Message.parseFrom(TEST_PREFIX_COMMAND_LASTPARAMETER);
        assertNotNull(msg);
        assertEquals(USR, msg.getPrefix());
        assertEquals(CMD, msg.getCommand());
        assertEquals(LST, msg.getLastParameter());
    }

    @Test
    public void testPrefixCommandParameterLastParameter() {
        Message msg = Message.parseFrom(TEST_PREFIX_COMMAND_PARAMETER_LASTPARAMETER);
        assertNotNull(msg);
        assertEquals(USR, msg.getPrefix());
        assertEquals(CMD, msg.getCommand());
        assertNotNull(msg.getParameters());
        assertArrayEquals(new String[]{CHN}, msg.getParameters().toArray());
        assertEquals(LST, msg.getLastParameter());
    }

    @Test
    public void testToString() {
        Message msg = new Message();
        msg.setPrefix(USR);
        msg.setCommand(CMD);
        msg.addParameter(CHN);
        msg.setLastParameter(LST);

        assertEquals(TEST_PREFIX_COMMAND_PARAMETER_LASTPARAMETER, msg.toString());
    }
}
