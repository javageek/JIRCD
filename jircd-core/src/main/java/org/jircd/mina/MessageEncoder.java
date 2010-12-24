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

import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineEncoder;
import org.jircd.Message;

import java.nio.charset.Charset;

/**
 * IRC Message Encoder. This class extends from MINA's {@link TextLineEncoder} since that one provides most of the
 * requirements needed for encoding, including using a line delimiter of CR/LF. The only difference is that the IRC
 * message has a max length of 510 (plus the CR/LF characters, which makes a total of 512) according to RFC2812 Section
 * 2.3.
 *
 * @author <a href="mailto:github@javageek.org">Guillermo Castro</a>
 */
public class MessageEncoder extends TextLineEncoder {

    /**
     * Create a new instance of the MessageEncoder object.
     *
     * @param charset of type {@link Charset} which determines the encoding characters.
     */
    public MessageEncoder(Charset charset) {
        super(charset, LineDelimiter.CRLF);
        setMaxLineLength(Message.MAX_LENGTH);
    }

}
