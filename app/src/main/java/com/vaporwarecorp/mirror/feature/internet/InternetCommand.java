/*
 * Copyright 2016 Johann Reyes
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
package com.vaporwarecorp.mirror.feature.internet;

import com.hound.core.model.sdk.CommandResult;
import com.robopupu.api.dependency.Provides;
import com.robopupu.api.dependency.Scope;
import com.robopupu.api.plugin.Plug;
import com.robopupu.api.plugin.Plugin;
import com.vaporwarecorp.mirror.app.MirrorAppScope;
import com.vaporwarecorp.mirror.component.command.AbstractHoundifyCommand;
import com.vaporwarecorp.mirror.component.command.HoundifyCommand;
import com.vaporwarecorp.mirror.feature.Command;
import com.vaporwarecorp.mirror.feature.MainFeature;
import com.vaporwarecorp.mirror.feature.common.presenter.VideoPlayerPresenter;

@Plugin
public class InternetCommand extends AbstractHoundifyCommand implements HoundifyCommand {
// ------------------------------ FIELDS ------------------------------

    private static final String COMMAND_EXPRESSION = "connect to the internet";
    private static final String COMMAND_INTENT = "ConnectToTheInternet";
    private static final String COMMAND_RESPONSE = "Ok, connecting to the internet";

    @Plug
    MainFeature mFeature;

// --------------------------- CONSTRUCTORS ---------------------------

    @Scope(MirrorAppScope.class)
    @Provides(Command.class)
    public InternetCommand() {
        super(COMMAND_INTENT, COMMAND_EXPRESSION, COMMAND_RESPONSE);
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface Command ---------------------

    @Override
    public void executeCommand(CommandResult result) {
        mFeature.showPresenter(InternetPresenter.class);
    }

    @Override
    public String getCommandTypeValue() {
        return COMMAND_INTENT;
    }
}
