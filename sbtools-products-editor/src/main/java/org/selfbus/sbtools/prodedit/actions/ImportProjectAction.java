package org.selfbus.sbtools.prodedit.actions;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import org.selfbus.sbtools.common.Config;
import org.selfbus.sbtools.common.gui.actions.BasicAction;
import org.selfbus.sbtools.common.gui.components.Dialogs;
import org.selfbus.sbtools.common.gui.misc.ImageCache;
import org.selfbus.sbtools.prodedit.ProdEdit;
import org.selfbus.sbtools.prodedit.filter.ProductsFileFilter;
import org.selfbus.sbtools.prodedit.internal.I18n;
import org.selfbus.sbtools.vdio.VdioException;

/**
 * Import a project.
 */
public final class ImportProjectAction extends BasicAction
{
   private static final long serialVersionUID = -1435990577579163569L;

   /**
    * Create an action object.
    */
   public ImportProjectAction()
   {
      super(I18n.getMessage("ImportProjectAction.name"), I18n.getMessage("ImportProjectAction.toolTip"), ImageCache
            .getIcon("icons/fileopen"));
   }

   /**
    * Perform the action.
    */
   @Override
   public void actionEvent(ActionEvent ev)
   {
      ProdEdit app = ProdEdit.getInstance();
      final JFrame mainWin = app.getMainFrame();

      final Config cfg = Config.getInstance();
      String lastDir = cfg.getStringValue("project.lastImportDir");

      final JFileChooser dlg = new JFileChooser();
      dlg.setCurrentDirectory(new File(lastDir));
      final FileFilter fileFilter = new ProductsFileFilter();
      dlg.addChoosableFileFilter(fileFilter);
      dlg.addChoosableFileFilter(dlg.getAcceptAllFileFilter());
      dlg.setFileFilter(fileFilter);
      dlg.setDialogTitle(I18n.getMessage("ImportProjectAction.title"));

      if (dlg.showOpenDialog(mainWin) != JFileChooser.APPROVE_OPTION)
         return;

      final File file = dlg.getSelectedFile();
      if (file == null) return;

      cfg.put("project.lastImportDir", file.getParent());

      try
      {
         mainWin.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
         app.getProjectService().importProject(file);
         app.setStatusMessage(I18n.formatMessage("Project.imported", file.getName()));
      }
      catch (FileNotFoundException | VdioException e)
      {
         Dialogs.showExceptionDialog(e, I18n.formatMessage("Error.read", file.getName()));
      }
      finally
      {
         mainWin.setCursor(Cursor.getDefaultCursor());
      }
   }
}
