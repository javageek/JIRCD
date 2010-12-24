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
public class MessageTest implements TestConstants {
    private static final String TEST_WHITESPACE = SPC;
    private static final String TEST_COMMAND = CMD;
    private static final String TEST_COMMAND_PARAMETER = CMD + SPC + CHN;
    private static final String TEST_COMMAND_LAST_PARAMETER = CMD + SPC + PRE + SRV;
    private static final String TEST_COMMAND_PARAMETER_LAST_PARAMETER = CMD + SPC + CHN + SPC + PRE + LST;
    private static final String TEST_PREFIX_COMMAND = PRE + SRV + SPC + CMD;
    private static final String TEST_PREFIX_COMMAND_PARAMETER = PRE + USR + SPC + CMD + SPC + CHN;
    private static final String TEST_PREFIX_COMMAND_LAST_PARAMETER = PRE + USR + SPC + CMD + SPC + PRE + LST;
    private static final String TEST_PREFIX_COMMAND_PARAMETER_LAST_PARAMETER = PRE + USR + SPC + CMD + SPC + CHN + SPC + PRE + LST;
    private static final String TEST_CTCP_MSG = PRE + USR + SPC + CMD + SPC + CHN + SPC + PRE + CTCP_MSG;

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
        Message msg = Message.parseFrom(TEST_COMMAND_LAST_PARAMETER);
        assertNotNull(msg);
        assertEquals(CMD, msg.getCommand());
        assertEquals(SRV, msg.getLastParameter());
    }

    @Test
    public void testCommandParameterLastParameter() {
        Message msg = Message.parseFrom(TEST_COMMAND_PARAMETER_LAST_PARAMETER);
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
        Message msg = Message.parseFrom(TEST_PREFIX_COMMAND_LAST_PARAMETER);
        assertNotNull(msg);
        assertEquals(USR, msg.getPrefix());
        assertEquals(CMD, msg.getCommand());
        assertEquals(LST, msg.getLastParameter());
    }

    @Test
    public void testPrefixCommandParameterLastParameter() {
        Message msg = Message.parseFrom(TEST_PREFIX_COMMAND_PARAMETER_LAST_PARAMETER);
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
        assertEquals("", msg.toString());

        msg.setCommand(CMD);
        assertEquals(TEST_COMMAND, msg.toString());

        msg.setPrefix(SRV);
        assertEquals(TEST_PREFIX_COMMAND, msg.toString());

        msg.setPrefix(USR);
        msg.addParameter(CHN);
        assertEquals(TEST_PREFIX_COMMAND_PARAMETER, msg.toString());

        msg.setLastParameter(LST);
        assertEquals(TEST_PREFIX_COMMAND_PARAMETER_LAST_PARAMETER, msg.toString());
    }

    @Test
    public void testCTCPtoString() throws Exception {
        Message msg = new Message();
        msg.setPrefix(USR);
        msg.setCommand(CMD);
        msg.addParameter(CHN);
        msg.setLastParameter(CTCP_MSG);

        assertEquals(TEST_CTCP_MSG, msg.toString());
    }

    @Test
    public void testGetParameterSize() {
        Message msg = new Message();

        assertNull(msg.getParameters());
        assertEquals(0, msg.getParameterSize());

        msg.addParameter(CHN);

        assertNotNull(msg.getParameters());
        assertArrayEquals(new String[]{CHN}, msg.getParameters().toArray());
        assertEquals(1, msg.getParameterSize());
    }

    @Test
    public void testMessageType() throws Exception {
        Message msg = new Message();

        assertEquals(MessageType.UNKNOWN, msg.getMessageType());

        msg.setMessageType(MessageType.PRIVMSG);
        assertEquals(MessageType.PRIVMSG, msg.getMessageType());
        assertEquals(MessageType.PRIVMSG.getCommand(), msg.getCommand());
    }
}
