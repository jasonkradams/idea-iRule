// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.f5.irules.sdk.language.psi;

import com.f5.irules.sdk.language.IRulesLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IRulesElementType extends IElementType {

    public IRulesElementType(@NotNull @NonNls String debugName) {
        super(debugName, IRulesLanguage.INSTANCE);
    }

}
