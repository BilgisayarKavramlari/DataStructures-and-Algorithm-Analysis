#!/usr/bin/env bash
set -euo pipefail

find . -name '*.class' -delete

for lab in lab-*; do
  if [ -d "$lab" ] && find "$lab" -maxdepth 1 -name '*.java' -print -quit | grep -q .; then
    echo "Compiling $lab"
    (cd "$lab" && javac *.java)
  fi
done

echo "All Coding Labs compiled successfully."
