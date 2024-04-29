// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package com.f5.irules.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class IRulesFileType extends LanguageFileType {

    public static final IRulesFileType INSTANCE = new IRulesFileType();

    private IRulesFileType() {
        super(IRulesLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "IRules File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "IRules language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "irul";
    }

    @Override
    public Icon getIcon() {
        return IRulesIcons.FILE;
    }

}
