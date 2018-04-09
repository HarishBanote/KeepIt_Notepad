import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.wb.swt.SWTResourceManager;

public class About {

	private static  int CONST_WIDTH =446;
	private static  int CONST_HEIGHT =302;
	protected Shell shlAbout;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			About window = new About();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAbout.open();
		shlAbout.layout();
		
	shlAbout.addControlListener(new ControlListener() {
			
			@Override
			public void controlResized(ControlEvent e) {
				// TODO Auto-generated method stub
				Rectangle rect = shlAbout.getBounds();
				if(rect.width != CONST_WIDTH || rect.height != CONST_WIDTH){
					shlAbout.setBounds(rect.x, rect.y, CONST_WIDTH,CONST_HEIGHT);
				}
				
			}
			@Override
			public void controlMoved(ControlEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		while (!shlAbout.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAbout = new Shell();
		shlAbout.setImage(SWTResourceManager.getImage(About.class, "/kepps.png"));
		shlAbout.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		shlAbout.setSize(446, 302);
		shlAbout.setText("About");
		shlAbout.setLayout(new FormLayout());
		
		Label lblKeepit = new Label(shlAbout, SWT.NONE);
		lblKeepit.setAlignment(SWT.CENTER);
		FormData fd_lblKeepit = new FormData();
		fd_lblKeepit.bottom = new FormAttachment(100, -220);
		fd_lblKeepit.top = new FormAttachment(0, 10);
		fd_lblKeepit.left = new FormAttachment(0, 174);
		fd_lblKeepit.right = new FormAttachment(100, -176);
		lblKeepit.setLayoutData(fd_lblKeepit);
		lblKeepit.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		lblKeepit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblKeepit.setFont(SWTResourceManager.getFont("Expo", 16, SWT.NORMAL));
		lblKeepit.setText("KeepIt");
		
		Label lblDesignAndDeveloped = new Label(shlAbout, SWT.NONE);
		lblDesignAndDeveloped.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		lblDesignAndDeveloped.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblDesignAndDeveloped.setAlignment(SWT.CENTER);
		FormData fd_lblDesignAndDeveloped = new FormData();
		fd_lblDesignAndDeveloped.top = new FormAttachment(lblKeepit, 20);
		fd_lblDesignAndDeveloped.left = new FormAttachment(0, 125);
		fd_lblDesignAndDeveloped.right = new FormAttachment(100, -110);
		lblDesignAndDeveloped.setLayoutData(fd_lblDesignAndDeveloped);
		lblDesignAndDeveloped.setText("Design and Developed by : -");
		
		Label lblHarishBanote = new Label(shlAbout, SWT.NONE);
		fd_lblDesignAndDeveloped.bottom = new FormAttachment(lblHarishBanote, -18);
		lblHarishBanote.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		lblHarishBanote.setAlignment(SWT.CENTER);
		lblHarishBanote.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblHarishBanote.setFont(SWTResourceManager.getFont("Kristen ITC", 12, SWT.BOLD));
		FormData fd_lblHarishBanote = new FormData();
		fd_lblHarishBanote.right = new FormAttachment(100, -144);
		lblHarishBanote.setLayoutData(fd_lblHarishBanote);
		lblHarishBanote.setText("Harish Banote");
		
		Label lblContactHarishbanotegmailcom = new Label(shlAbout, SWT.NONE);
		lblContactHarishbanotegmailcom.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		fd_lblHarishBanote.bottom = new FormAttachment(100, -136);
		lblContactHarishbanotegmailcom.setAlignment(SWT.CENTER);
		lblContactHarishbanotegmailcom.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.ITALIC));
		FormData fd_lblContactHarishbanotegmailcom = new FormData();
		fd_lblContactHarishbanotegmailcom.top = new FormAttachment(lblHarishBanote, 11);
		fd_lblContactHarishbanotegmailcom.right = new FormAttachment(100, -86);
		lblContactHarishbanotegmailcom.setLayoutData(fd_lblContactHarishbanotegmailcom);
		lblContactHarishbanotegmailcom.setText("Contact : harishbanote96@gmail.com");

	}
}
