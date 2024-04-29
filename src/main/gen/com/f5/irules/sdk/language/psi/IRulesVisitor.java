// This is a generated file. Not intended for manual editing.
package com.f5.irules.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class IRulesVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull IRulesProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull IRulesNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
