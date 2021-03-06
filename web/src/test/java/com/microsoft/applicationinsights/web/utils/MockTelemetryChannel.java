/*
 * ApplicationInsights-Java
 * Copyright (c) Microsoft Corporation
 * All rights reserved.
 *
 * MIT License
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the ""Software""), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.applicationinsights.web.utils;

import com.microsoft.applicationinsights.channel.TelemetryChannel;
import com.microsoft.applicationinsights.channel.TelemetrySampler;
import com.microsoft.applicationinsights.telemetry.Telemetry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yonisha on 2/2/2015.
 */
public enum MockTelemetryChannel implements TelemetryChannel {
    INSTANCE;

    List<Telemetry> telemetryItems = new ArrayList<Telemetry>();

    public <E> List<E> getTelemetryItems(Class<E> eClass) {
        List<E> filtered = new ArrayList<E>();

        for (Telemetry telemetry : telemetryItems) {
            if (eClass.isInstance(telemetry)) {
                filtered.add(eClass.cast(telemetry));
            }
        }

        return filtered;
    }

    @Override
    public boolean isDeveloperMode() {
        return true;
    }

    @Override
    public void setDeveloperMode(boolean value) {

    }

    @Override
    public void send(Telemetry item) {
        telemetryItems.add(item);
    }

    @Override
    public void stop(long timeout, TimeUnit timeUnit) {

    }

    @Override
    public void flush() {
    }

    public void reset() {
        telemetryItems.clear();
    }

    @Override
    public void setSampler(TelemetrySampler telemetrySampler) {
    }
}
