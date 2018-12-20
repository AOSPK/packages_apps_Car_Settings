/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.car.settings.common;

import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.car.settings.location.LocationSettingsFragment;
import com.android.car.settings.wifi.WifiSettingsFragment;


/**
 * Maps an Action string to a {@link Fragment} that can handle this Action.
 */
public class FragmentResolver {
    private FragmentResolver() {}

    /**
     * Returns a {@link Fragment} that can handle the given action, returns {@code null} if no
     * {@link Fragment} that can handle this action can be found.
     */
    static @Nullable Fragment getFragmentForAction(String action) {
        switch (action) {
            case Settings.ACTION_LOCATION_SOURCE_SETTINGS:
                return new LocationSettingsFragment();
            case android.net.wifi.WifiManager.ACTION_PICK_WIFI_NETWORK:
            case Settings.ACTION_WIFI_SETTINGS:
                return new WifiSettingsFragment();
            default:
                return null;
        }
    }
}