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

import java.util.ArrayList;
import java.util.List;

/** @author <a href="mailto:github@javageek.org">Guillermo Castro</a> */
public class Message {
    private static final String MSG_SEPARATOR = " ";
    private static final String PREFIX_IDENTIFIER = ":";

    protected String prefix;
    protected String command;
    protected List<String> parameters;
    protected String lastParameter;

    /**
     * Create a Message object from an IRC command line. 
     *
     * @param line of type String
     * @return Message
     */
    public static Message parseFrom(String line) {
        Message msg = null;
        if (null != line && !line.trim().isEmpty()) {
            msg = new Message();
            String[] parts = line.split(MSG_SEPARATOR);
            if (parts.length > 1) {
                int partIndex = 0;
                String first = parts[partIndex++];
                if(first.startsWith(PREFIX_IDENTIFIER)) {
                    msg.setPrefix(first.substring(1));
                    msg.setCommand(parts[partIndex++]);
                } else {
                    msg.setCommand(first);
                }
                boolean lastParameterFound = false;
                StringBuffer lastParameter = null;
                for (int i = partIndex; i < parts.length; i++) {
                    if(parts[i].startsWith(PREFIX_IDENTIFIER)) {
                        lastParameterFound = true;
                        parts[i] = parts[i].substring(1);
                        lastParameter = new StringBuffer();
                    }
                    if (lastParameterFound) {
                        lastParameter.append(parts[i]);
                        if (i < parts.length -1) {
                            lastParameter.append(MSG_SEPARATOR);
                        }
                    } else {
                        msg.addParameter(parts[i]);
                    }
                }
                if (lastParameterFound) {
                    msg.setLastParameter(lastParameter.toString());
                }
            } else {
                // Single command
                msg.setCommand(parts[0]);
            }
        }
        return msg;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();

        if (null != prefix) {
            buf.append(PREFIX_IDENTIFIER).append(prefix).append(MSG_SEPARATOR);
        }
        if (null != command) {
            buf.append(command).append(MSG_SEPARATOR);
        }
        if (null != parameters && !parameters.isEmpty()) {
            for (String parameter : parameters) {
                buf.append(parameter).append(MSG_SEPARATOR);
            }
        }
        if (null != lastParameter) {
            buf.append(PREFIX_IDENTIFIER).append(lastParameter);
        }

        return buf.toString().trim();
    }

    /**
     * Method getPrefix gets the prefix of this Message object.
     *
     * @return the prefix (type String) of this Message object.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Method setPrefix sets the prefix of this Message object.
     *
     * @param prefix the prefix of this Message object.
     *
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Method getCommand gets the command of this Message object.
     *
     * @return the command (type String) of this Message object.
     */
    public String getCommand() {
        return command;
    }

    /**
     * Method setCommand sets the command of this Message object.
     *
     * @param command the command of this Message object.
     *
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Method getParameters gets the parameters of this Message object.
     *
     * @return the parameters (type List<String>) of this Message object.
     */
    public List<String> getParameters() {
        return parameters;
    }

    /**
     * Add parameter to List.
     *
     * @param parameter of type String
     */
    public void addParameter(String parameter) {
        if (null == parameters) {
            parameters = new ArrayList<String>();
        }
        parameters.add(parameter);
    }

    /**
     * Get the size of the parameter list.
     *
     * @return the parameterSize (type int) of this Message object.
     */
    public int getParameterSize() {
        return null == parameters ? 0 : parameters.size();
    }

    /**
     * Method getLastParameter gets the lastParameter of this Message object.
     *
     * @return the lastParameter (type String) of this Message object.
     */
    public String getLastParameter() {
        return lastParameter;
    }

    /**
     * Method setLastParameter sets the lastParameter of this Message object.
     *
     * @param lastParameter the lastParameter of this Message object.
     *
     */
    public void setLastParameter(String lastParameter) {
        this.lastParameter = lastParameter;
    }
}
