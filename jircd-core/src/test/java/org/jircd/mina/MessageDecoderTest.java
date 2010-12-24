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
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.jircd.Message;
import org.jircd.TestConstants;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import static junit.framework.Assert.assertEquals;

/** @author <a href="mailto:github@javageek.org">Guillermo Castro</a> */
public class MessageDecoderTest implements TestConstants {
    private static final String TEST_MSG = PRE + SRV + SPC + CMD + SPC + CHN + SPC + PRE + LST + CRLF;

    @Test
    public void testDecode() throws Exception {
        MessageProtocolCodecFactory factory = new MessageProtocolCodecFactory();

        ProtocolCodecSession session = new ProtocolCodecSession();
        ProtocolDecoder decoder = factory.getDecoder(session);
        ProtocolDecoderOutput out = session.getDecoderOutput();

        CharsetEncoder encoder = Charset.defaultCharset().newEncoder();
        IoBuffer in = IoBuffer.allocate(512);
        in.putString(TEST_MSG, encoder);
        in.flip();
        
        decoder.decode(session, in, out);
        
        Message msg = new Message();
        msg.setPrefix(SRV);
        msg.setCommand(CMD);
        msg.addParameter(CHN);
        msg.setLastParameter(LST);

        assertEquals(1, session.getDecoderOutputQueue().size());
        assertEquals(msg, session.getDecoderOutputQueue().poll());
    }
}
