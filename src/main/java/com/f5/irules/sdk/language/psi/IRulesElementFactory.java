// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.f5.irules.sdk.language.psi;

import com.f5.irules.sdk.language.IRulesFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;

public class IRulesElementFactory {

    public static IRulesProperty createProperty(Project project, String name) {
        final IRulesFile file = createFile(project, name);
        return (IRulesProperty) file.getFirstChild();
    }

    public static IRulesFile createFile(Project project, String text) {
        String name = "dummy.irul";
        return (IRulesFile) PsiFileFactory.getInstance(project).createFileFromText(name, IRulesFileType.INSTANCE, text);
    }

    public static IRulesProperty createProperty(Project project, String name, String value) {
        final IRulesFile file = createFile(project, name + " = " + value);
        return (IRulesProperty) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final IRulesFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

}
