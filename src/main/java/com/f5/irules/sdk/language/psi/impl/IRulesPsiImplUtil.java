// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package com.f5.irules.sdk.language.psi.impl;

import com.f5.irules.sdk.language.psi.IRulesElementFactory;
import com.f5.irules.sdk.language.psi.IRulesProperty;
import com.f5.irules.sdk.language.psi.IRulesTypes;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class IRulesPsiImplUtil {

    public static String getKey(IRulesProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(IRulesTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(IRulesProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(IRulesTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(IRulesProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(IRulesProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(IRulesTypes.KEY);
        if (keyNode != null) {
            IRulesProperty property = IRulesElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(IRulesProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(IRulesTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final IRulesProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }

}
