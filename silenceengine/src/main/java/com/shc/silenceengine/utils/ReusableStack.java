/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2017 Sri Harsha Chilakapati
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

package com.shc.silenceengine.utils;

import com.shc.silenceengine.core.SilenceException;
import com.shc.silenceengine.utils.functional.Provider;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> Any typed parameter.
 *
 * @author Sri Harsha Chilakapati
 */
public final class ReusableStack<T>
{
    private final Object lock = new Object();

    private List<T> stack;
    private List<T>  list;

    private Provider<T> objectProvider;

    public ReusableStack(Provider<T> objectProvider)
    {
        stack = new ArrayList<>();
        list = new ArrayList<>();
        this.objectProvider = objectProvider;
    }

    public T pop()
    {
        synchronized (lock)
        {
            if (stack.size() == 0)
                try
                {
                    T object = objectProvider.provide();

                    list.add(object);
                    stack.add(object);
                }
                catch (Exception e)
                {
                    SilenceException.reThrow(e);
                }

            return stack.remove(stack.size() - 1);
        }
    }

    public void push(T value)
    {
        synchronized (lock)
        {
            stack.add(value);
        }
    }

    public List<T> getAsList()
    {
        return list;
    }
}
