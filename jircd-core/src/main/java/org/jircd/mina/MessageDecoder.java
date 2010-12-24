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

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineDecoder;
import org.jircd.Message;

import java.nio.charset.Charset;

/**
 * Class for Decoding IRC messages. This class extends from {@link TextLineDecoder} which provides most of the
 * functionality required for decoding IRC messages. The method {@link #writeText} is replaced to generate the {@link
 * Message} object.
 *
 * @author <a href="mailto:github@javageek.org">Guillermo Castro</a>
 */
public class MessageDecoder extends TextLineDecoder {

    /**
     * Create a new MessageDecoder instance configured for IRC message decoding. Line delimiter is set to be {@link
     * LineDelimiter#CRLF} and the max length of the line is set to {@link Message#MAX_LENGTH}.
     *
     * @param charset of type Charset
     */
    public MessageDecoder(Charset charset) {
        super(charset, LineDelimiter.CRLF);
        setMaxLineLength(Message.MAX_LENGTH);
    }

    /**
     * Write text converts the decoded line to a {@link Message} object.
     *
     * @param session of type IoSession
     * @param text    of type String
     * @param out     of type ProtocolDecoderOutput
     */
    @Override
    protected void writeText(IoSession session, String text, ProtocolDecoderOutput out) {
        Message msg = Message.parseFrom(text);
        // Only write successful messages
        if (null != msg) {
            out.write(msg);
        }
    }
}
