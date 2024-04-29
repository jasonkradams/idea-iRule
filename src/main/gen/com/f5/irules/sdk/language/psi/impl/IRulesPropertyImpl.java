// This is a generated file. Not intended for manual editing.
package com.f5.irules.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.f5.irules.sdk.language.psi.IRulesTypes.*;
import com.f5.irules.sdk.language.psi.*;
import com.intellij.navigation.ItemPresentation;

public class IRulesPropertyImpl extends IRulesNamedElementImpl implements IRulesProperty {

  public IRulesPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IRulesVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IRulesVisitor) accept((IRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return IRulesPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return IRulesPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return IRulesPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return IRulesPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return IRulesPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return IRulesPsiImplUtil.getPresentation(this);
  }

}
