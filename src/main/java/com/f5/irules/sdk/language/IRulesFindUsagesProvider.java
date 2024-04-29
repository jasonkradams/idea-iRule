// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package com.f5.irules.sdk.language;

import com.f5.irules.sdk.language.psi.IRulesProperty;
import com.f5.irules.sdk.language.psi.IRulesTokenSets;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class IRulesFindUsagesProvider implements FindUsagesProvider {

    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new IRulesLexerAdapter(),
                IRulesTokenSets.IDENTIFIERS,
                IRulesTokenSets.COMMENTS,
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof IRulesProperty) {
            return "irules property";
        }
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof IRulesProperty) {
            return ((IRulesProperty) element).getKey();
        }
        return "";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof IRulesProperty) {
            return ((IRulesProperty) element).getKey() +
                    IRulesAnnotator.IRULES_SEPARATOR_STR +
                    ((IRulesProperty) element).getValue();
        }
        return "";
    }

}
