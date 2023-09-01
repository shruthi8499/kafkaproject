package com.rest;


import com.rest.DisasterRecoveryListener;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DisasterRecoveryTest {

    @InjectMocks
    private DisasterRecoveryListener listener;

    @Mock
    private FileWriter fileWriter;

    @Test
    public void testProcessDisasterRecoveryLog() throws IOException {
        MockitoAnnotations.initMocks(this);

        // Mock LocalDateTime and DateTimeFormatter
        LocalDateTime now = LocalDateTime.of(2023, 9, 1, 12, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        when(LocalDateTime.now()).thenReturn(now);
        when(formatter.format(now)).thenReturn("2023-09-01 12:00:00");

        // Mock logMessage
        String logMessage = "Test log message";

        // Call the method to be tested
        listener.processDisasterRecoveryLog(logMessage);

        // Verify that the logEntry is built correctly
        String expectedLogEntry = "[2023-09-01 12:00:00] Test log message\n";

        // Verify that the FileWriter is used to write the log entry
        verify(fileWriter).write(expectedLogEntry);
    }

    @Test
    public void testProcessDisasterRecoveryLogWithError() throws IOException {
        MockitoAnnotations.initMocks(this);

        // Mock logMessage
        String logMessage = "Test log message";

        // Mock an exception when writing to FileWriter
        doThrow(new IOException("Error writing to file")).when(fileWriter).write(any(String.class));

        // Call the method to be tested
        listener.processDisasterRecoveryLog(logMessage);

        // Verify that an error message is logged
        verify(DisasterRecoveryListener.logger).error("Error saving disaster recovery log: Error writing to file", any(IOException.class));
    }
}
