package frc.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.commands.*;
import frc.robot.commands.command_groups.*;
import frc.robot.commands.test_commands.C_EndEffectorDirect;
import frc.robot.commands.test_commands.C_FrontClimberDirect;
import frc.robot.commands.test_commands.C_RearClimberDirect;
import frc.robot.input.IGamepad;
import frc.robot.input.XboxGamepad;
import frc.robot.input.DPadButton.Direction;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private IGamepad primaryController = new XboxGamepad(0);
    private IGamepad secondaryController = new XboxGamepad(1);
    private IGamepad testingController = new XboxGamepad(2);

    private Robot mRobot;

    public OI(Robot robot) {
        mRobot = robot;
    }

    public void registerControls() {
        //
        //primary controller
        //
        

        primaryController.getStartButton().whenPressed(new C_ZeroDrivetrainGyro(mRobot.getDrivetrain()));
        
        primaryController.getXButton().whenPressed(new CG_BallIntake()); 

        primaryController.getBackButton().whenPressed(new CG_CancelIntake());

        primaryController.getLeftBumperButton().whenPressed(new C_VisionAlign());

        primaryController.getYButton().whenPressed(new C_VisionAlignStrafe());

        primaryController.addShiftButton("kickstand extend", primaryController.getAButton(), primaryController.getRightTriggerButton());

        primaryController.getShiftButton("kickstand extend").whenPressed(new C_ExtendKickstand(true));

        primaryController.addShiftButton("kickstand retract", primaryController.getBButton(), primaryController.getRightTriggerButton());

        primaryController.getShiftButton("kickstand retract").whenPressed(new C_ExtendKickstand(false));
        // primaryController.getBButton().whenPressed(new C_RearClimberToAngle(0));
        // primaryController.getBButton().whenReleased(new C_RearClimberToAngle(5));
        //primaryController.getYButton().whenPressed(new CG_FeederBallIntake());

        // primaryController.getBButton().whenPressed(new C_DefenseMode(true));
        // primaryController.getBButton().whenReleased(new C_DefenseMode(false));
        primaryController.getBButton().whenPressed(new C_DefenseMode());

        

        //
        //secondary controller
        //

        secondaryController.getDPadButton(Direction.UP).whenPressed(new C_SetSelectedLevel(3));
        secondaryController.getDPadButton(Direction.LEFT).whenPressed(new C_SetSelectedLevel(2));
        secondaryController.getDPadButton(Direction.DOWN).whenPressed(new C_SetSelectedLevel(1));
        secondaryController.getDPadButton(Direction.RIGHT).whenPressed(new C_SetSelectedLevel(15));


        // secondaryController.getLeftBumperButton().whenPressed(new CG_GoToSelectedLevelBack());
        secondaryController.getLeftBumperButton().whenPressed(new C_SelectUp());

        secondaryController.getRightBumperButton().whenPressed(new C_SelectDown());

        secondaryController.getXButton().whenPressed(new C_SetMode());
        secondaryController.getXButton().whenReleased(new C_SelectMode());

        secondaryController.getAButton().whenPressed(new C_SetEFIntakeSpeed(1));
        secondaryController.getAButton().whenReleased(new C_SetEFIntakeSpeed(0));

        secondaryController.getBButton().whenPressed(new C_ExtendHatch(true));
        secondaryController.getBButton().whenReleased(new CG_HatchDrop());

        // secondaryController.getYButton().whenPressed(new CG_HatchHold());

        secondaryController.getYButton().whenPressed(new CG_HatchIntake());
        secondaryController.getYButton().whenReleased(new CG_HatchIntakeManual());
        
        // secondaryController.getYButton().whenPressed(new CG_HatchIntake());
        // secondaryController.getYButton().whenReleased(new CG_HatchIntakeManual());

        secondaryController.getStartButton().whenPressed(new C_Climb(false));
        secondaryController.getStartButton().whenReleased(new C_Climb(true));


        secondaryController.getBackButton().whenPressed(new C_CrabDrive(.6));
        
        secondaryController.addShiftButton("restartEF", secondaryController.getLeftTriggerButton(), secondaryController.getRightTriggerButton());
        secondaryController.getShiftButton("restartEF").whenPressed(new CG_AdjustAngleEncoder());

        secondaryController.addShiftButton("fclimbman", secondaryController.getBackButton(), secondaryController.getLeftTriggerButton());
        secondaryController.getShiftButton("fclimbman").whenPressed(new C_FrontClimberDirect());

        secondaryController.addAntiShiftButton("fclimb crab", secondaryController.getBackButton(), secondaryController.getLeftTriggerButton());
        secondaryController.getAntiShiftButton("fclimb crab").whenPressed(new C_CrabDrive(.6));
        
        //
        //testing controller: BE CAREFUL
        //

        
        //NOTE: order of buttons and expirations DO MATTER make sure they are on the same index
        // ArrayList<Button> test_Buttons = new ArrayList<Button>();    
        // test_Buttons.add(testingController.getAButton());
        // test_Buttons.add(testingController.getBButton());
        
        // ArrayList<Number> test_expirations = new ArrayList<Number>();
        // test_expirations.add(500);
        // test_expirations.add(500);


        // testingController.addComboButton("test", test_Buttons, test_expirations, 1000);
        
        // testingController.getComboButton("test").whenPressed(new CG_BallIntake());

    }
    
    public IGamepad getTestController(){
        return testingController;
    }
    public IGamepad getSecondaryController(){
        return secondaryController;
    }
    public IGamepad getPrimaryController() {
        return primaryController;
    }

}
