import com.intellij.ide.projectView.ProjectView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;

/**
 * Created by zhengpeng on 2016/10/19.
 */
public class FindInProjectView extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        PsiFile psiFile = e.getData(PlatformDataKeys.PSI_FILE);
        if (psiFile != null) {
            PsiFile[] filesByName = FilenameIndex.getFilesByName(e.getProject(), psiFile.getName(), GlobalSearchScope.fileScope(psiFile));
            ProjectView.getInstance(e.getProject()).selectPsiElement(filesByName[0], true);
        } else {
            Messages.showMessageDialog("No file chosen or No file found .\nNavigator Bar will show your chosen file(Recently we didnt support file dir).\n Github:https://github.com/tmac1999/", "For any questions ,please write an issue in github", Messages.getInformationIcon());
        }
    }
}
