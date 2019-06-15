package org.academiadecodigo.whiledlings.whiledbits;


import org.academiadecodigo.whiledlings.whiledbits.gfx.GfxGamePad;
import org.academiadecodigo.whiledlings.whiledbits.gfx.Player;
import org.academiadecodigo.whiledlings.whiledbits.pads.Pads;
import org.academiadecodigo.whiledlings.whiledbits.pads.PadsNotes;
import org.academiadecodigo.whiledlings.whiledbits.pads.PadsSample;
import org.academiadecodigo.whiledlings.whiledbits.sound.SoundsGroup;


public class Game {

    private SoundsGroup selectedGroup;
    private Pads selectedPadGroup;
    private GfxGamePad gfxGamePad;
    private PadsSample drums = new PadsSample(SoundsGroup.DRUMS);
    private PadsSample samples = new PadsSample(SoundsGroup.SAMPLES);
    private PadsNotes notes = new PadsNotes(SoundsGroup.NOTES);

    public void startPad() {

        gfxGamePad = new GfxGamePad();
        gfxGamePad.drawPad();

        selectedGroup = SoundsGroup.DRUMS;
        selectedPadGroup = drums;

        Player player = new Player(drums, samples, notes, this);
        player.init();

    }

    public void selectGroup(SoundsGroup soundsGroup) {

        selectedGroup = soundsGroup;

        switch (selectedGroup) {
            case DRUMS:
                selectedPadGroup = drums;
                break;
            case SAMPLES:
                selectedPadGroup = samples;
                break;
            case NOTES:
                selectedPadGroup = notes;
                break;
        }

    }

    public SoundsGroup getSelectedGroup() {
        return selectedGroup;
    }

    public Pads getSelectedPadGroup() {
        return selectedPadGroup;
    }
}