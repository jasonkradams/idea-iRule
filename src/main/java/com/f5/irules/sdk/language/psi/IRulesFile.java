// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.f5.irules.sdk.language.psi;

import com.f5.irules.sdk.language.IRulesFileType;
import com.f5.irules.sdk.language.IRulesLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class IRulesFile extends PsiFileBase {

    public IRulesFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, IRulesLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return IRulesFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "IRules File";
    }

}
