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

package org.jircd.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.jircd.Message;
import org.jircd.MessageType;
import org.jircd.TestConstants;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

/** @author <a href="mailto:github@javageek.org">Guillermo Castro</a> */
public class MessageEncoderTest implements TestConstants {
    private static final String TEST_OUTPUT = CMD + SPC + USR + SPC + PRE + LST + CRLF;
    private static final String TEST_CTCP_OUTPUT = CMD + SPC + USR + SPC + PRE + CTCP_MSG + CRLF;

    @Test
    public void testEncode() throws Exception {
        MessageProtocolCodecFactory factory = new MessageProtocolCodecFactory();

        ProtocolCodecSession session = new ProtocolCodecSession();
        ProtocolEncoder encoder = factory.getEncoder(session);
        ProtocolEncoderOutput out = session.getEncoderOutput();

        Message msg = new Message();

        encoder.encode(session, msg, out);
        assertEquals(1, session.getEncoderOutputQueue().size());
        IoBuffer buffer = (IoBuffer) session.getEncoderOutputQueue().poll();
        assertEquals(2, buffer.remaining());
        assertEquals('\r', buffer.get());
        assertEquals('\n', buffer.get());

        msg.setMessageType(MessageType.PRIVMSG);
        msg.addParameter(USR);
        msg.setLastParameter(LST);

        encoder.encode(session, msg, out);
        assertEquals(1, session.getEncoderOutputQueue().size());
        buffer = (IoBuffer) session.getEncoderOutputQueue().poll();
        assertEquals(TEST_OUTPUT.length(), buffer.remaining());
        assertEquals(TEST_OUTPUT, buffer.getString(Charset.defaultCharset().newDecoder()));

        msg.setLastParameter(CTCP_MSG);
        encoder.encode(session, msg, out);
        assertEquals(1, session.getEncoderOutputQueue().size());
        buffer = (IoBuffer) session.getEncoderOutputQueue().poll();
        assertEquals(TEST_CTCP_OUTPUT.length(), buffer.remaining());
        assertEquals(TEST_CTCP_OUTPUT, buffer.getString(Charset.defaultCharset().newDecoder()));
    }
}
