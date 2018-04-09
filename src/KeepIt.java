import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class KeepIt {

	private static String font;
	private static int font_Size;
	private static String path;
	static StyledText styledText;
	static Label lblWelcome ;

	public static void main(String[] args){
		Display display = Display.getDefault();
		Shell shlKeepit = new Shell();
		shlKeepit.setImage(SWTResourceManager.getImage(KeepIt.class, "/kepps.png"));
		shlKeepit.setSize(477, 340);
		shlKeepit.setText("KeepIt");
		font = "Times New Roman";
		font_Size = 20;
		
		shlKeepit.setLayout(new FormLayout());
		
		
		Menu menu = new Menu(shlKeepit, SWT.BAR);
		shlKeepit.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmNew = new MenuItem(menu_1, SWT.NONE);
		mntmNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KeepIt.main(null);
					
			}
		});
		mntmNew.setText("New");
		
		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				  FileDialog dialog = new FileDialog(shlKeepit, SWT.OPEN);
				  String extensions[] = {"*.txt","*.java","*.html","*.xml","*.ino"};
					dialog.setFilterExtensions(extensions);
				  path = dialog.open();
				  if (path != null) {
					  File file = new File(path);
					  if (file.isFile())
						  displayFiles(new String[] { file.toString()});
						  else
						  displayFiles(file.list());
				  }
			}
		});
		mntmOpen.setText("Open");
		
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		
		mntmSave.setText("Save");
		
		MenuItem mntmExite = new MenuItem(menu_1, SWT.NONE);
		mntmExite.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlKeepit.close();
			}
		});
		mntmExite.setText("Exit");
		
		MenuItem mntmView = new MenuItem(menu, SWT.CASCADE);
		mntmView.setText("View");
		
		Menu menu_2 = new Menu(mntmView);
		mntmView.setMenu(menu_2);
		
		MenuItem mntmFont_2 = new MenuItem(menu_2, SWT.CASCADE);
		mntmFont_2.setText("Edit");
		
		Menu menu_4 = new Menu(mntmFont_2);
		mntmFont_2.setMenu(menu_4);
		
		MenuItem mntmFont_3 = new MenuItem(menu_4, SWT.CASCADE);
		mntmFont_3.setText("Font");
		
		Menu menu_5 = new Menu(mntmFont_3);
		
		mntmFont_3.setMenu(menu_5);
		styledText = new StyledText(shlKeepit, SWT.BORDER);
		styledText.setFont(SWTResourceManager.getFont(font, font_Size, SWT.NORMAL));
		styledText.setAlignment(SWT.CENTER);
		styledText.setTabStops(new int[] {12});
		FormData fd_styledText = new FormData();
		fd_styledText.top = new FormAttachment(0, 10);
		fd_styledText.right = new FormAttachment(100, -10);
		fd_styledText.left = new FormAttachment(0, 10);
		fd_styledText.bottom = new FormAttachment(100, -29);
		styledText.setLayoutData(fd_styledText);
		
		MenuItem mntmT = new MenuItem(menu_5, SWT.RADIO);
		mntmT.setText("Times New Roman");
		
		MenuItem mntmC = new MenuItem(menu_5, SWT.RADIO);
		mntmC.setText("Calibri");
		
		MenuItem mntmA = new MenuItem(menu_5, SWT.RADIO);
		mntmA.setText("@Arial Unicode MS");
		
		MenuItem mntmK = new MenuItem(menu_5, SWT.RADIO);
		mntmK.setText("Kruti Dev 010");
		
		MenuItem mntmS= new MenuItem(menu_5, SWT.RADIO);
		mntmS.setText("Serifa BT");
		
		MenuItem mntmF = new MenuItem(menu_5, SWT.RADIO);
		mntmF.setText("Freestyle Script");
		
		MenuItem mntmTextSize = new MenuItem(menu_4, SWT.CASCADE);
		mntmTextSize.setText("Text Size");
	
		mntmT.addSelectionListener(new SelectionAdapter() {
		

			@Override
			public void widgetSelected(SelectionEvent e) {
			
			font = "Times New Roman";
		//	font_Size = 32;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
			}
		});
		
		mntmC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font = "Calibri";
				//font_Size = 32;
			
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
			}
		});
		
		mntmA.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font = "@Arial Unicode MS";
			//	font_Size = 32;
			
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
			}
		});
		
		mntmS.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font = "Serifa BT";
				//	font_Size = 32;
			
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
			}
		});
		
		mntmF.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font = "Freestyle Script";
				//	font_Size = 32;
			
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
			}
		});
		
		mntmK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font = "Kruti Dev 010";
				//	font_Size = 32;
			
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
			}
		});
		
		Menu menu_6 = new Menu(mntmTextSize);
		mntmTextSize.setMenu(menu_6);
	
			
			MenuItem menuItem_9 = new MenuItem(menu_6, SWT.RADIO);
			menuItem_9.setText("9");
			
			MenuItem menuItem_10 = new MenuItem(menu_6, SWT.RADIO);
			menuItem_10.setText("10");
			
		MenuItem menuItem_11= new MenuItem(menu_6, SWT.RADIO);
		menuItem_11.setText("11");
		
		MenuItem menuItem_12 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_12.setText("12");
		
		MenuItem menuItem_14 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_14.setText("14");
		
		MenuItem menuItem_16 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_16.setText("16");
		
		MenuItem menuItem_18 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_18.setText("18");
		
		MenuItem menuItem_20 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_20.setText("20");
		
		MenuItem menuItem_22 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_22.setText("22");
		
		MenuItem menuItem_24 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_24.setText("24");
		
		MenuItem menuItem_26 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_26.setText("26");
		
		MenuItem menuItem_28 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_28.setText("28");
		
		MenuItem menuItem_36 = new MenuItem(menu_6, SWT.RADIO);
		menuItem_36.setText("36");
		
		menuItem_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				font_Size= 9;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 10;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 11;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 12;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 14;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 16;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		
		menuItem_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 18;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		
		menuItem_20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 20;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 22;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 24;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 26;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 28;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		menuItem_36.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				font_Size= 36;
				styledText.setFont(SWTResourceManager.getFont(font,font_Size, SWT.NORMAL));
				
				
			}
		});
		
		
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_3 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_3);
		
		MenuItem mntmAbout = new MenuItem(menu_3, SWT.NONE);
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				About about = new About();
				about.open();
			}
		});
		mntmAbout.setText("About");
		
		
		
		 lblWelcome = new Label(shlKeepit, SWT.NONE);
		FormData fd_lblWelcome = new FormData();
		fd_lblWelcome.right = new FormAttachment(styledText, 0, SWT.RIGHT);
		fd_lblWelcome.top = new FormAttachment(styledText, 6);
		fd_lblWelcome.left = new FormAttachment(styledText, 10, SWT.LEFT);
		lblWelcome.setLayoutData(fd_lblWelcome);
		lblWelcome.setText("Welcome to KeepIt.");

		mntmSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(shlKeepit, SWT.SAVE);
				dialog.setText("Save");
				String extensions[] = {"*.txt","*.java","*.html","*.xml","*.ino"};
				dialog.setFilterExtensions(extensions);
				  path = dialog.open();
			
			
					try
					{
						FileOutputStream f = new FileOutputStream(path);
						String s = styledText.getText();
						byte a[] = s.getBytes();
						f.write(a);
						f.close();
						lblWelcome.setText("Saved successfully.");
						
					}
					catch(Exception io)
					{
		
					}
			}

		});
		
		shlKeepit.open();
		shlKeepit.layout();
		while (!shlKeepit.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	public static void displayFiles(String[] files) {
		  for (int i = 0; files != null && i < files.length; i++)
			  styledText.setText(files[i]);
		String path_open =  styledText.getText();
		  styledText.setText("");
			  
		  try
		  {
			 FileInputStream fi = new FileInputStream(path_open);
				int i = 0;
			
				while((i = fi.read())!=-1)
				{
					String a = String.valueOf((char) i);
					styledText.append(a);
				}
				lblWelcome.setText("File path : - "+path_open);
				fi.close();
		  }
		catch(Exception fi)
		  {
			
		  }

	}
}
