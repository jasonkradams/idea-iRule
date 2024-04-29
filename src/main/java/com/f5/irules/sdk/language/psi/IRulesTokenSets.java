// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package com.f5.irules.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface IRulesTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(IRulesTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(IRulesTypes.COMMENT);

}
