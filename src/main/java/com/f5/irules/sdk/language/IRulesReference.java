// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package com.f5.irules.sdk.language;

import com.f5.irules.sdk.language.psi.IRulesProperty;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

final class IRulesReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String key;

    IRulesReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<IRulesProperty> properties = IRulesUtil.findProperties(project, key);
        List<ResolveResult> results = new ArrayList<>();
        for (IRulesProperty property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<IRulesProperty> properties = IRulesUtil.findProperties(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final IRulesProperty property : properties) {
            if (property.getKey() != null && !property.getKey().isEmpty()) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(IRulesIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }

}
