#!/bin/bash

# 引数チェック
if [ $# -ne 1 ]; then
  echo "Usage: $0 <problem-number>"
  exit 1
fi

NUM=$(printf "%02d" "$1") # 01, 02, ..., 99 にゼロ埋め
PROBLEM="Problem${NUM}"

# パス設定
SRC_DIR="src/main/scala/s99"
TEST_DIR="src/test/scala"
TEMPLATE_DIR="template"

# 作成先ファイル
SRC_FILE="${SRC_DIR}/${PROBLEM}.scala"
TEST_FILE="${TEST_DIR}/${PROBLEM}Spec.scala"

# テンプレートファイル
TEMPLATE_SRC="${TEMPLATE_DIR}/ProblemTemplate.scala"
TEMPLATE_TEST="${TEMPLATE_DIR}/ProblemSpecTemplate.scala"

# ファイルコピー
mkdir -p "$SRC_DIR" "$TEST_DIR"

if [ ! -f "$TEMPLATE_SRC" ] || [ ! -f "$TEMPLATE_TEST" ]; then
  echo "Template files not found in ${TEMPLATE_DIR}"
  exit 1
fi

cp "$TEMPLATE_SRC" "$SRC_FILE"
cp "$TEMPLATE_TEST" "$TEST_FILE"

# プレースホルダ置換
sed -i "" "s/ProblemXX/${PROBLEM}/g" "$SRC_FILE"
sed -i "" "s/ProblemXX/${PROBLEM}/g" "$TEST_FILE"

echo "Created:"
echo "  $SRC_FILE"
echo "  $TEST_FILE"
