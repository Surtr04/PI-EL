#!/bin/bash

MUSIC_DIR=$1;

if [ "$MUSIC_DIR" == "" ]
	then 
		echo "no directory provided"
		exit			
fi


	
sed -i '' -e 's/chordef:/chorddef:/g' $MUSIC_DIR/*
sed -i '' -e 's/Singer:/singer:/g' $MUSIC_DIR/*
sed -i '' -e 's/From:/from:/g' $MUSIC_DIR/*
sed -i '' -e 's/form:/from:/g' $MUSIC_DIR/*
sed -i '' -e 's/Music:/music:/g' $MUSIC_DIR/*
sed -i '' -e 's/Author:/author:/g' $MUSIC_DIR/*
sed -i '' -e 's/Lyrics:/lyrics:/g' $MUSIC_DIR/*
sed -i '' -e 's/ntitle:/''/g' $MUSIC_DIR/*
sed -i '' -e 's/Arranjo:/arrangement:/g' $MUSIC_DIR/*
sed -i '' -e 's/arranjo:/arrangement:/g' $MUSIC_DIR/*
sed -i '' -e 's/Tom:/tone:/g' $MUSIC_DIR/*
sed -i '' -e 's/In:/in:/g' $MUSIC_DIR/*
sed -i '' -e 's/Comm:/comm:/g' $MUSIC_DIR/*
sed -i '' -e 's/commp:/comm:/g' $MUSIC_DIR/*
sed -i '' -e 's/com:/comm:/g' $MUSIC_DIR/*
sed -i '' -e 's/Letra:/lyrics:/g' $MUSIC_DIR/*
sed -i '' -e 's/Date:/date:/g' $MUSIC_DIR/*
