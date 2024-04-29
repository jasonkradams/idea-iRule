// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.f5.irules.sdk.language.psi.impl;

import com.f5.irules.sdk.language.psi.IRulesNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class IRulesNamedElementImpl extends ASTWrapperPsiElement implements IRulesNamedElement {

    public IRulesNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
