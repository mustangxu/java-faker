package com.github.javafaker;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.github.javafaker.repeating.RepeatRule;

public class AbstractFakerTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Spy
    protected Faker faker;

    @BeforeEach
    public void before() throws Exception {
        try (var m = MockitoAnnotations.openMocks(this);) {
        }

        var rootLogger = LogManager.getLogManager().getLogger("");
        var handlers = rootLogger.getHandlers();
        rootLogger.setLevel(Level.INFO);
        for (Handler h : handlers) {
            h.setLevel(Level.INFO);
        }
    }

}
