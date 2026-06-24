#!/usr/bin/env bash
set -euo pipefail

find . -name '*.class' -delete

for folder in lab-* practice-module-*; do
  if [ -d "$folder" ] && find "$folder" -maxdepth 1 -name '*.java' -print -quit | grep -q .; then
    echo "Compiling $folder"
    (cd "$folder" && javac *.java)
  fi
done

echo "All Coding Labs and Practice Modules compiled successfully."
