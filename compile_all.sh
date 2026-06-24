#!/usr/bin/env bash
set -euo pipefail
find . -name '*.class' -delete
for folder in practice-*; do
  if [ -d "$folder" ]; then
    echo "Compiling $folder"
    (cd "$folder" && javac *.java)
  fi
done
echo "All practice folders compiled successfully."
