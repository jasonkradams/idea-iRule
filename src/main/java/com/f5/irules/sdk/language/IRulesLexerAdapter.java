// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.f5.irules.sdk.language;

import com.intellij.lexer.FlexAdapter;

public class IRulesLexerAdapter extends FlexAdapter {

    public IRulesLexerAdapter() {
        super(new IRulesLexer(null));
    }

}
