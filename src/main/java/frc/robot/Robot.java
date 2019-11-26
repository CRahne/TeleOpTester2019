package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ExampleSubsystem;

public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public Talon Talon1 = new Talon(1);
  // public Timer time = new Timer();
  public Joystick stick1 = new Joystick(0);

  private double startTime;

  public void robotInit() {
  }

  public void robotPeriodic() {
  }

  public void disabledInit() {
  }

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void autonomousInit() {
    // startTime = time.get();
  }

  public void autonomousPeriodic() {
    // double diff_t = time.get() - startTime;
    // double speed = ((-4/125) * (diff_t - 5) * (diff_t - 5)) + 0.8;
    // Talon1.set(speed);
    // SmartDashboard.putNumber("Volt", speed);
    // SmartDashboard.putNumber("Time",diff_t);
  }


  public void teleopInit() {
    double gain = 0.2;
    double targ = stick1.getRawAxis(0);
    double curr = Talon1.get();
    double new_setvolt = (gain * (targ - curr)) + curr;
    Talon1.set(new_setvolt);
  }

  public void teleopPeriodic() {
    // Constants
    double gain = 0.2;
    
    // Set Values
    double targ = stick1.getRawAxis(0);
    double curr = Talon1.get();
    double new_setvolt = (gain * (targ - curr)) + curr;
    
    // Sets Talon to New Voltage
    Talon1.set(new_setvolt);
    
    // 
    SmartDashboard.putNumber("Setpoint", new_setvolt);
    SmartDashboard.putNumber("Target", targ);
    SmartDashboard.putNumber("Current", curr);
    SmartDashboard.putNumber("Gain", gain);
  }

  public void testPeriodic() {
  }
}
