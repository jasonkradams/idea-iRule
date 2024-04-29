# IRules Language Sample [![JetBrains IntelliJ Platform SDK Docs](https://jb.gg/badges/docs.svg)][docs]
*Reference: [Custom Language Support Tutorial in IntelliJ SDK Docs][docs:custom_language_support_tutorial]*

## Quickstart

Defines a new language, _IRules language_ with support for syntax highlighting, annotations, code completion, and other features.

### Extension Points

| Name                                          | Implementation                                                                          | Extension Point Class               |
|-----------------------------------------------|-----------------------------------------------------------------------------------------|-------------------------------------|
| `com.intellij.fileType`                       | [IRulesFileType][file:IRulesFileType]                                                   | `LanguageFileType`                  |
| `com.intellij.lang.parserDefinition`          | [IRulesParserDefinition][file:IRulesParserDefinition]                                   | `ParserDefinition`                  |
| `com.intellij.lang.syntaxHighlighterFactory`  | [IRulesSyntaxHighlighterFactory][file:IRulesSyntaxHighlighterFactory]                   | `SyntaxHighlighterFactory`          |
| `com.intellij.colorSettingsPage`              | [IRulesColorSettingsPage][file:IRulesColorSettingsPage]                                 | `ColorSettingsPage`                 |
| `com.intellij.annotator`                      | [IRulesAnnotator][file:IRulesAnnotator]                                                 | `Annotator`                         |
| `com.intellij.codeInsight.lineMarkerProvider` | [IRulesLineMarkerProvider][file:IRulesLineMarkerProvider]                               | `RelatedItemLineMarkerProvider`     |
| `com.intellij.completion.contributor`         | [IRulesCompletionContributor][file:IRulesCompletionContributor]                         | `CompletionContributor`             |
| `com.intellij.psi.referenceContributor`       | [IRulesReferenceContributor][file:IRulesReferenceContributor]                           | `PsiReferenceContributor`           |
| `com.intellij.lang.refactoringSupport`        | [IRulesRefactoringSupportProvider][file:IRulesRefactoringSupportProvider]               | `RefactoringSupportProvider`        |
| `com.intellij.lang.findUsagesProvider`        | [IRulesFindUsagesProvider][file:IRulesFindUsagesProvider]                               | `FindUsagesProvider`                |
| `com.intellij.lang.foldingBuilder`            | [IRulesFoldingBuilder][file:IRulesFoldingBuilder]                                       | `FoldingBuilderEx`                  |
| `com.intellij.gotoSymbolContributor`          | [IRulesChooseByNameContributor][file:IRulesChooseByNameContributor]                     | `ChooseByNameContributor`           |
| `com.intellij.lang.psiStructureViewFactory`   | [IRulesStructureViewFactory][file:IRulesStructureViewFactory]                           | `PsiStructureViewFactory`           |
| `com.intellij.lang.formatter`                 | [IRulesFormattingModelBuilder][file:IRulesFormattingModelBuilder]                       | `FormattingModelBuilder`            |
| `com.intellij.codeStyleSettingsProvider`      | [IRulesCodeStyleSettingsProvider][file:IRulesCodeStyleSettingsProvider]                 | `CodeStyleSettingsProvider`         |
| `com.intellij.langCodeStyleSettingsProvider`  | [IRulesLanguageCodeStyleSettingsProvider][file:IRulesLanguageCodeStyleSettingsProvider] | `LanguageCodeStyleSettingsProvider` |
| `com.intellij.lang.commenter`                 | [IRulesCommenter][file:IRulesCommenter]                                                 | `Commenter`                         |

*Reference: [Plugin Extension Points in IntelliJ SDK Docs][docs:ep]*


[docs]: https://plugins.jetbrains.com/docs/intellij/
[docs:custom_language_support_tutorial]: https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html
[docs:ep]: https://plugins.jetbrains.com/docs/intellij/plugin-extensions.html

[file:IRulesFileType]: ./src/main/java/com/f5/irules/sdk/language/IRulesFileType.java
[file:IRulesParserDefinition]: ./src/main/java/com/f5/irules/sdk/language/IRulesParserDefinition.java
[file:IRulesSyntaxHighlighterFactory]: ./src/main/java/com/f5/irules/sdk/language/IRulesSyntaxHighlighterFactory.java
[file:IRulesColorSettingsPage]: ./src/main/java/com/f5/irules/sdk/language/IRulesColorSettingsPage.java
[file:IRulesAnnotator]: src/main/java/com/f5/irules/sdk/language/IRulesAnnotator.java
[file:IRulesLineMarkerProvider]: ./src/main/java/com/f5/irules/sdk/language/IRulesLineMarkerProvider.java
[file:IRulesCompletionContributor]: ./src/main/java/com/f5/irules/sdk/language/IRulesCompletionContributor.java
[file:IRulesReferenceContributor]: ./src/main/java/com/f5/irules/sdk/language/IRulesReferenceContributor.java
[file:IRulesRefactoringSupportProvider]: ./src/main/java/com/f5/irules/sdk/language/IRulesRefactoringSupportProvider.java
[file:IRulesFindUsagesProvider]: ./src/main/java/com/f5/irules/sdk/language/IRulesFindUsagesProvider.java
[file:IRulesFoldingBuilder]: ./src/main/java/com/f5/irules/sdk/language/IRulesFoldingBuilder.java
[file:IRulesChooseByNameContributor]: ./src/main/java/com/f5/irules/sdk/language/IRulesChooseByNameContributor.java
[file:IRulesStructureViewFactory]: ./src/main/java/com/f5/irules/sdk/language/IRulesStructureViewFactory.java
[file:IRulesFormattingModelBuilder]: ./src/main/java/com/f5/irules/sdk/language/IRulesFormattingModelBuilder.java
[file:IRulesCodeStyleSettingsProvider]: ./src/main/java/com/f5/irules/sdk/language/IRulesCodeStyleSettingsProvider.java
[file:IRulesLanguageCodeStyleSettingsProvider]: ./src/main/java/com/f5/irules/sdk/language/IRulesLanguageCodeStyleSettingsProvider.java
[file:IRulesCommenter]: ./src/main/java/com/f5/irules/sdk/language/IRulesCommenter.java

