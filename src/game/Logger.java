/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Logger is used to log every actions occurring during a Game.
 */
public class Logger {

    /**
     * Logger unique instance.
     */
    private static Logger instanceLogger = new Logger();

    /**
     * Get the logger unique instance.
     *
     * @return logger instance.
     */
    public static Logger getLogger() {
        if (instanceLogger == null) {
            instanceLogger = new Logger();
        }
        return instanceLogger;
    }

    /**
     * List of actions logged.
     */
    public List<String> logs = new ArrayList<>();

    /**
     * Log a new action.
     *
     * @param message to save in the logs.
     */
    public void log(String message) {
        logs.add(message);
    }
    
    /**
     * Display all logs in stdout.
     */
    public void showLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
