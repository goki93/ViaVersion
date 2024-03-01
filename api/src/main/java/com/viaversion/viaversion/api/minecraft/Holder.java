/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2024 ViaVersion and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.viaversion.viaversion.api.minecraft;

import com.google.common.base.Preconditions;

public final class Holder<T> {

    private final T value;
    private final int id;

    public Holder(final int id) {
        this.value = null;
        this.id = id;
    }

    public Holder(final T value) {
        this.value = value;
        this.id = -1;
    }

    /**
     * Returns true if this holder is backed by a direct value.
     *
     * @return true if the holder is direct
     * @see #hasId()
     */
    public boolean isDirect() {
        return id == -1;
    }

    /**
     * Returns true if this holder has an id.
     *
     * @return true if this holder has an id
     * @see #isDirect()
     */
    public boolean hasId() {
        return id != -1;
    }

    public T value() {
        Preconditions.checkArgument(isDirect(), "Holder is not direct");
        return value;
    }

    public int id() {
        return id;
    }
}
