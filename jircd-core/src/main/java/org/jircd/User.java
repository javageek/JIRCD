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

/** @author <a href="mailto:github@javageek.org">Guillermo Castro</a> */
public class User {
    private String nickname;
    private String username;
    private String hostname;
    // TODO: Replace with a different entity
    private String usermode;

    /**
     * Returns the nickname for the user.
     *
     * @return the nickname (type String) of this User object.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname for the user.
     *
     * @param nickname the nickname of this User object.
     *
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the username for the user.
     *
     * @return the username (type String) of this User object.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the user.
     *
     * @param username the username of this User object.
     *
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the hostname for the user.
     *
     * @return the hostname (type String) of this User object.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets the hostname for the user.
     *
     * @param hostname the hostname of this User object.
     *
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Gets the user mode
     *
     * @return the usermode (type String) of this User object.
     */
    public String getUsermode() {
        return usermode;
    }

    /**
     * Method setUsermode sets the usermode of this User object.
     *
     * @param usermode the usermode of this User object.
     *
     */
    public void setUsermode(String usermode) {
        this.usermode = usermode;
    }
}
