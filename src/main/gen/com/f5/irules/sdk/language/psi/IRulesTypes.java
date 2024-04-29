// This is a generated file. Not intended for manual editing.
package com.f5.irules.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.f5.irules.sdk.language.psi.impl.*;

public interface IRulesTypes {

  IElementType PROPERTY = new IRulesElementType("PROPERTY");

  IElementType COMMENT = new IRulesTokenType("COMMENT");
  IElementType CRLF = new IRulesTokenType("CRLF");
  IElementType KEY = new IRulesTokenType("KEY");
  IElementType SEPARATOR = new IRulesTokenType("SEPARATOR");
  IElementType VALUE = new IRulesTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new IRulesPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
