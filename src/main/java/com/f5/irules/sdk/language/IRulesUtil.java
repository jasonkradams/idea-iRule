// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.f5.irules.sdk.language;

import com.f5.irules.sdk.language.psi.IRulesFile;
import com.f5.irules.sdk.language.psi.IRulesProperty;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class IRulesUtil {

    /**
     * Searches the entire project for Irules language files with instances of the IRules property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<IRulesProperty> findProperties(Project project, String key) {
        List<IRulesProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(IRulesFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            IRulesFile IRulesFile = (IRulesFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (IRulesFile != null) {
                IRulesProperty[] properties = PsiTreeUtil.getChildrenOfType(IRulesFile, IRulesProperty.class);
                if (properties != null) {
                    for (IRulesProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<IRulesProperty> findProperties(Project project) {
        List<IRulesProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(IRulesFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            IRulesFile IRulesFile = (IRulesFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (IRulesFile != null) {
                IRulesProperty[] properties = PsiTreeUtil.getChildrenOfType(IRulesFile, IRulesProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

    /**
     * Attempts to collect any comment elements above the IRules key/value pair.
     */
    public static @NotNull String findDocumentationComment(IRulesProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result), "\n ");
    }

}
