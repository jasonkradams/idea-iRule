// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package com.f5.irules.sdk.language;

import com.f5.irules.sdk.language.psi.IRulesFile;
import com.f5.irules.sdk.language.psi.IRulesProperty;
import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

final class IRulesStructureAwareNavbar extends StructureAwareNavBarModelExtension {

    @NotNull
    @Override
    protected Language getLanguage() {
        return IRulesLanguage.INSTANCE;
    }

    @Override
    public @Nullable String getPresentableText(Object object) {
        if (object instanceof IRulesFile) {
            return ((IRulesFile) object).getName();
        }
        if (object instanceof IRulesProperty) {
            return ((IRulesProperty) object).getName();
        }

        return null;
    }

    @Override
    @Nullable
    public Icon getIcon(Object object) {
        if (object instanceof IRulesProperty) {
            return AllIcons.Nodes.Property;
        }

        return null;
    }

}
