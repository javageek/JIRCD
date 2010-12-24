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
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

/**
 * A {@link ProtocolCodecFactory} that performs encoding and decoding between an IRC text line
 * terminated in CR/LF and a {@link org.jircd.Message} object. If the message length is longer
 * than 510 bytes, the encoder/decoder will throw an {@link IllegalArgumentException}.
 *
 * @author <a href="mailto:github@javageek.org">Guillermo Castro</a>
 */
public class MessageProtocolCodecFactory implements ProtocolCodecFactory {
    private final MessageEncoder encoder;
    private final MessageDecoder decoder;

    /**
     * Creates a new MessageProtocolCodecFactory instance using a default {@link Charset}.
     *
     * @see java.nio.charset.Charset#defaultCharset()
     */
    public MessageProtocolCodecFactory() {
        this(Charset.defaultCharset());
    }

    /**
     * Creates a new MessageProtocolCodecFactory instance using the specified {@link Charset}.
     *
     * @param charset The charset to use in the encoding and decoding of messages.
     * @see Charset
     */
    public MessageProtocolCodecFactory(Charset charset) {
        encoder = new MessageEncoder(charset);
        decoder = new MessageDecoder(charset);
    }

    /**
     * Return
     *
     * @param session of type IoSession
     * @return ProtocolEncoder
     * @throws Exception when
     */
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return encoder;
    }

    /**
     * Method getDecoder ...
     *
     * @param session of type IoSession
     * @return ProtocolDecoder
     * @throws Exception when
     */
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return decoder;
    }
}
