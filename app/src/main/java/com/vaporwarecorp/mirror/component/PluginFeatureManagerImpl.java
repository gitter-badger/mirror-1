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
package com.vaporwarecorp.mirror.component;

import com.robopupu.api.dependency.Provides;
import com.robopupu.api.dependency.Scope;
import com.robopupu.api.feature.AbstractFeatureManager;
import com.robopupu.api.feature.Feature;
import com.robopupu.api.feature.FeatureContainer;
import com.robopupu.api.plugin.Plugin;
import com.robopupu.api.plugin.PluginBus;
import com.robopupu.api.util.Params;
import com.vaporwarecorp.mirror.app.MirrorAppScope;

@Plugin
public class PluginFeatureManagerImpl extends AbstractFeatureManager implements PluginFeatureManager {
// --------------------------- CONSTRUCTORS ---------------------------

    @Scope(MirrorAppScope.class)
    @Provides(PluginFeatureManager.class)
    public PluginFeatureManagerImpl() {
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface FeatureManager ---------------------

    @Override
    public Feature startFeature(final FeatureContainer container, final Feature feature, final Params params) {
        PluginBus.plug(feature);
        return super.startFeature(container, feature, params);
    }
}